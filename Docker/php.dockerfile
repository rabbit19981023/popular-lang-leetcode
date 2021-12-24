FROM php:8.0-fpm as php

RUN apt-get update
RUN apt-get install -y vim
COPY ./vim.config /root/.vimrc

# install composer (PHP Packages Manager)
RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer \
    && chmod +x /usr/local/bin/composer

# install zip & unzip for composer
RUN apt-get install -y zip unzip

# install PHPUnit into $PATH to make it become globally
RUN curl -o /usr/local/bin/phpunit --location https://phar.phpunit.de/phpunit-9.phar \
    && chmod +x /usr/local/bin/phpunit
