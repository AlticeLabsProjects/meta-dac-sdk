SUMMARY = "DAC Container with SDL test application"

inherit  dac-image-base

IMAGE_INSTALL = "helloworld-test"

# needed
OCI_IMAGE_ENTRYPOINT = "/usr/bin/helloworld-test"
APP_METADATA_PATH = "metadatas/helloworld-test-appmetadata.json"

# optional
OCI_IMAGE_AUTHOR = "LGi"
OCI_IMAGE_AUTHOR_EMAIL = "info@lgi.com"
OCI_IMAGE_ENTRYPOINT_ARGS = ""
OCI_IMAGE_WORKINGDIR = "/"
