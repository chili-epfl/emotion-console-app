# emotion-console-app:
Android Ros application that shows the current status of the child learning progress using plots

Overview
========

Python dependencies:
```
shape_learning
```

Required libraries:
```
AndroidPlot Rosjava
```

Installation
============

In order to be able to receive the data properly, it is necessary to execute the file `graph_values_publisher.py` in the `shape_learning` package. It basically processes all log files and sends the information of each shape
