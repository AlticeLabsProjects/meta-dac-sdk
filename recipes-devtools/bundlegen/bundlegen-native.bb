SUMMARY="bundlegen generator"
SECTION="devtools"
LICENSE= "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=32a3c2c37f9b6d1a2b8d9a636844d6cd"

SRC_URI = "git://github.com/rdkcentral/BundleGen.git;protocol=https;branch=master"
SRC_URI:append = "file://test.sh"
SRC_REV = "8022d4980a45acf560834735c161d98af6f9a9e0"

FILESEXTRAPATHS:prepend := "${THISDIR}:"

S = "${WORKDIR}/git"

inherit setuptools3 native

DEPENDS = "python3-native skopeo-native umoci-native python3-humanfriendly-native python3-click-native python3-loguru-native python3-jsonschema-native"

FILES:${PN}:append_class-nativesdk = " ${SDKPATHNATIVE}"
FILES:${PN}:append = " ${D}${prefix}/* ${D}{prefix}/templates/*/*.json"
FILES:${PN}:append = " ${D}{prefix}/schema/*.json"
FILES:${PN}:append = " ${D}{prefix}/test/testapp.sh"
FILES:${PN}:append = " ${D}{prefix}/test.sh"

do_install:append() { 
   install -d ${D}${datadir}/${BPN}/templates
   cp -rf ${S}/templates/* ${D}${datadir}/${BPN}/templates/
   install -d ${D}${datadir}/${BPN}/schema
   cp -rf ${S}/bundlegen/schema/* ${D}${datadir}/${BPN}/schema/
   -m 755 ${S}/test/testapp_lisa.sh ${D}${datadir}/${BPN}/testapp.sh
   install -m 755 ${WORKDIR}/test.sh ${D}${datadir}/${BPN}/
}

BBCLASSSEXTEND = "native nativesdk"