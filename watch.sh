#!/bin/sh

grunt watch &
lein cljsbuild auto &
wait
