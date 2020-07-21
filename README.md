This project is a part of my college course (OOP with java). This project trains a Logistic Regression model on a dataset of several SMSs whoch are labelled as "spam" or "ham" and uses the WEKA library.
The preprocessing modules were written by me and another team member. My job was to remove stop words, create a bag-of-words model and create a feature matrix with the bag of words model and then using the weka API to train the LR model.


To use this, open up dist/SpamDetector.jar
and select "train2.csv" file in the project directory for training. and hit the "Train" button.

After training is complete, you paste a message in the textbox and the model will attempt to classify it as spam / not spam.
