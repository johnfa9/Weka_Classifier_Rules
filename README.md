
# Weka_Classifier_Rules
<h2>
This project demonstrates how to implement an Airline Satisfaction Survey application using the rules generated by the Weka application. 
After opening a dataset, choose the J48 classifer under the 
"classify" tab, and select "More Options" and "Output source code".
</h2>
<br>
Step 1: Install Weka application
<br>
Step 2: Import the Weka jar file into IntelliJ.  The jar file can be found in the directory used during Weka installation.
<br>
Step 3: Check that the jar file appears in  the Intellij "External Libraries" Folder
<br>
Step 4: Start the Weka application and load the dataset.  The data used by this application is available in the "Data" folder. The .CSV file used to create the Weka .arff folder can be found here: https://www.kaggle.com/datasets/teejmahal20/airline-passenger-satisfaction
<br>
Step 5: In Weka, goto "classify" tab, press "Choose" and select "J48" classifier.
<br>
Step 6: After selecting J48 classifier, press "More Options" button and make sure "Output source code" is selected. Press Start button to generate the Classifier.
<br>
Step 7: The rules generated by Weka will be shown inside  the classifier results. Copy all of the code displayed  to an Intellij class file (See WekaWrapper.java).
<br>
Step 8: In Intellij, Run Main to start the application (See Main.java)