[![Build Status](https://travis-ci.org/rporrini/sale-taxes.svg?branch=master)](https://travis-ci.org/rporrini/sale-taxes)

# Sale Taxes

### Project Dependencies

* java
* gradle

### General Comments

1. The test class [AcceptanceTest](test/info/rporrini/saleTaxes/AcceptanceTest.java) shows that the provided solution is compliant with the supplied test data.
2. The solution assumes that the categories of the items are given (lines [74-82](test/info/rporrini/saleTaxes/AcceptanceTest.java#L74) of the [AcceptanceTest](test/info/rporrini/saleTaxes/AcceptanceTest.java) test class).
3. The other assumption is that the name of imported items always contains the keyword ```imported```. This heuristic is hard coded in the class [ImportedItemsTaxation](src/info/rporrini/saleTaxes/ImportedItemsTaxation.java). The code is designed to be open to new and different criteria.


