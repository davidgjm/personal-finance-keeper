#!/usr/bin/env bash

source ./gradle.properties

echo "${!springBootVersion@}=${springBootVersion}"
echo "${!springBootGradlePluginVersion@}=${springBootGradlePluginVersion}"
echo "${!gitCommitIdVersion@}=${gitCommitIdVersion}"

BUILD_SRC_PROPS="buildSrc/gradle.properties"

echo "${!sourceCompatibility@}=${sourceCompatibility}" > ${BUILD_SRC_PROPS}
echo "${!targetCompatibility@}=${targetCompatibility}" >> ${BUILD_SRC_PROPS}
echo "${!gitCommitIdVersion@}=${gitCommitIdVersion}" >> ${BUILD_SRC_PROPS}
echo "${!springBootVersion@}=${springBootVersion}" >> ${BUILD_SRC_PROPS}
echo "${!springBootGradlePluginVersion@}=${springBootGradlePluginVersion}" >> ${BUILD_SRC_PROPS}
