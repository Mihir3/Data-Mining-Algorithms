# Data-Mining-Algorithms

Project Report Link : ![alt text] (https://docs.google.com/document/d/1G13YBTMNjX7-OImDn3PTYl6wg6xY4TDbMYZzDKU_KLM/edit)
Kindly find the results of all the performed tasks and algorithms in the report link above.

# Abstract
In my semester project for Data Warehousing and Mining class at university, me and my team-mates built the proposed data-mining algorithms which performed an in-depth analysis on the randomly generated data of the popular fast-food chains. The three chains included in the survey were : Mcdonalds, KFC, Subway.  This system was designed to analyse the three verticals of the fast-food industry : Customer Base, Production and Offer-Systems(Find schemas at link attached). Accordingly, for analysis, a database of random entries was generated using Python libraries and MySQL that contained the details of various customer transactions and employee reports.

# Information Packages
The categories and relevant attributes for the three verticals i.e Customer-base, Production and Offer-Systems were established.

# Schemas
Extensive star and snowflake schemas of all three verticals were prepared to define the scope of the project.

# Queries
Five SQL queries were performed on the database to perform OLAP operations in order to obtains different views and extract information.

# Classifier
A Naïve Bayes Classifier was used to predict whether a customer of a certain age category would buy a food item.
Here, the model was trained with a training dataset of 2000 entries.
And, in the test dataset, out of 499 entries, 245 were rightly predicted by the classifier. Hence, the accuracy of the model is 49.09% which is quite less since the datasets were randomly generated.

# Clustering
A K-Means Clustering algorithm was used to divide 20 records of transactions of customers of certain age into three respective food chains (Mcdonalds, Subway, KFC).

# Assosciation Rule Mining
The apriori algorithm was used to get the association rules based on frequent itemsets to get more information about which food item is bought with another list of food items.

Note :
The dataset for this algorithm was built in the following format where each entry is in the format : (Transaction_id, Food_Item_no). The food items numbers vary between 111 to 115 as mentioned in the menu of established food chains. The data of 20 transactions was put to find the frequent itemsets through apriori algorithm.

# Density-Based Clustering 
DBSCAN algorithm can be used to perform unsupervised clustering over huge list of customer transactions to find patterns with optimum number of min_pts and epsilon radius value.






