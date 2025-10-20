docker run --name almond -it --rm -p 8888:8888 \
 -v "$(pwd)":/home/jovyan/work \
 -e JUPYTER_CONFIG_DIR="/home/jovyan/work/jupyter_config" \
 -e JUPYTER_TOKEN="almond"  almondsh/almond:latest