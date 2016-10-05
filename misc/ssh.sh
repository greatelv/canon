#!/bin/bash

chmod 400 ./pem/cannon.pem
ssh -i ./pem/cannon.pem ubuntu@p-northeast-2.compute.amazonaws.com
