SUMMARY = "Example SDL test application"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

#DEPENDS = "libgles2"
#DEPENDS:append = " libsdl2"

SRC_URI = "file://main.cpp"
SRC_URI:append = " file://LICENSE"

#inherit autotools pkgconfig

TEST_NAME = "helloworld-test"

TARGET_CC_ARCH:append = " ${LDFLAGS}"

do_compile () {
  cd ${WORKDIR}
  
  ${CXX} ${TARGET_CXXFLAGS} -o ${TEST_NAME} main.cpp #$(pkg-config --cflags --libs glesv2 sdl2)
}

do_install() {
  install -p -m 0755 -D ${WORKDIR}/${TEST_NAME} ${D}${bindir}/${TEST_NAME}
}

FILES:${PN}:append = " ${bindir}/*"

