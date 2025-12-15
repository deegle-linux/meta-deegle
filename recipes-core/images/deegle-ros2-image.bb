require deegle-base-image.bb

DESCRIPTION = "A Deegle Linux image providing ROS2."

IMAGE_INSTALL:append = " \
    ros-core \
    bash \
"
