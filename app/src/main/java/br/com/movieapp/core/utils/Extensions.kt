package br.com.movieapp.core.utils

import br.com.movieapp.BuildConfig

fun String?.toPostUrl() = "${BuildConfig.BASE_URL_IMAGE}$this"

fun String?.toBackDropUrl() = "${BuildConfig.BASE_URL_IMAGE}$this"