package com.example.domain.exceptions

import java.io.IOException


class ServerTimeOutException(message:Exception)
    :IOException(message) {


    }