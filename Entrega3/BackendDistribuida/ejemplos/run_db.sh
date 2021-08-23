#!/usr/bin/env bash


sudo kill -9 `sudo lsof -t -i:5000`
sudo kill -9 `sudo lsof -t -i:5001`
sudo kill -9 `sudo lsof -t -i:5002`

python main.py config0.json &
python main.py config1.json &
python main.py config2.json &