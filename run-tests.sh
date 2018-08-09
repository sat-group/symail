#!/bin/bash
export LC_NUMERIC=C

bench="syaddress"

function sypet-logo {
    echo "$(tput setaf 4)              ____     ___      __ $(tput sgr 0)"
    echo "$(tput setaf 4)             / __/_ __/ _ \___ / /_$(tput sgr 0)"
    echo "$(tput setaf 4)            _\ \/ // / ___/ -_) __/$(tput sgr 0)"
    echo "$(tput setaf 4)           /___/\_, /_/   \__/\__/ $(tput sgr 0)"
    echo "$(tput setaf 4)               /___/            $(tput sgr 0)"
}

function run-bench {    
    echo "$(tput setaf 4)[SyPet]$(tput sgr 0) Running $(tput bold)$bench$(tput sgr 0) benchmarks..."
    for f in synth/$bench/* ; do 
	id=$(basename $f)
    cd sypet ; ant sypet -Dargs="../$f/benchmark.json" &> /tmp/output.txt ; cd ..
    tab1="\t"
    tab2="\t\t"
    size=${#f} 
    if [ $size -gt 28 ] ; then
        tabc=$tab1
    else
        tabc=$tab2
    fi
    if grep -q Synthesized /tmp/output.txt ; then
	    echo -e "$(tput setaf 4)[SyPet]$(tput sgr 0) Benchmark $(tput bold)$f$(tput sgr 0) $tabc $(tput setaf 2)[OK]$(tput sgr 0)"
	else
	    echo -e "$(tput setaf 4)[SyPet]$(tput sgr 0) Benchmark $(tput bold)$f$(tput sgr 0) $tabc $(tput setaf 1)[FAILED]$(tput sgr 0)"
	fi
    done
}

sypet-logo

bench="syaddress"
run-bench

bench="sywindow"
run-bench

