FROM java:8

Maintainer Jason Webb <jason@jswebb.net>

RUN apt-get update && apt-get install -y \
    g++ \
    make

# Install Stockfish source
RUN git clone https://github.com/official-stockfish/Stockfish.git \
    && cd Stockfish/src \
    && make profile-build ARCH=x86-64