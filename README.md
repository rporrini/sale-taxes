[![Build Status](https://travis-ci.org/rporrini/sale-taxes.svg?branch=master)](https://travis-ci.org/rporrini/sale-taxes)

# Sale Taxes

### Project Dependencies

* java
* gradle

### General Comments

1. The test class [AcceptanceTest](test/info/rporrini/saleTaxes/AcceptanceTest.java) shows that the provided solution is compliant with the supplied test data.
2. To simplify the scope of the exercise, the solution assumes that a category of goods is provided as input for each item. The test data was extended accordingly, for example from ```1 chocolate bar at 0.85``` to ```1 chocolate bar at 0.85 food```.
3. Another simplification is the assumption that the input is already splitted into pieces of information about the purchased item and requires no extra parsing, for example from ```1 chocolate bar at 0.85 food``` to ```["1", "chocolate bar", "0.85", "food"]```.
4. The last simplification is that the name of imported items always contains the keyword ```imported```. This heuristic is hard coded in the class [ImportedItemsTaxation](src/info/rporrini/saleTaxes/ImportedItemsTaxation.java). The code is designed to be open to new and different criteria.

