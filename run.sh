#!/bin/sh
# we go to the app directory
cd $(dirname $(readlink -f $0))
# and execute -- modify this so that your AI is run
java RandomWalk
