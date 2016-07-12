# AndroidDatabaseLibraryComparison
A test between a few of the popular libraries running a speed test on how fast they load and save data.

Note:  SugarORM and ActiveAndroid and Sprinkles were removed because they're too slow.  If you're curious how well they run, you can uncomment the lines in MainActivity.  SugarORM was a lot slower on load/save.  ActiveAndroid and Sprinkles were a lot slower than the remaining comparisons on save.

## Benchmark Description

There are two benchmarks.  The Simple trial uses a flat schema for an address book so each row is composed of name, address, city, state, and phone columns.  The Simple trial does 25000 copies of the AddressItem.  

![Simple Address Item Schema](images/SimpleAddressItem.png "Simple Address Item Schema")

The Complex trial is hierarchical and has support for multiple address books where each address book has contacts and addresses.  The Complex trial does 50 copies of the AddressBook.

![Address Book Schema](images/AddressBook.png "Address Book Schema")

## Results

These are the results for the Simple trial:

![Simple Trial](images/simpletrial.png "Simple Trial")

And these are the results for the Complex trial:

![Complex Trial](images/complextrial.png "Complex Trial")

## Older Results

These are the results for the Simple trial with the DBs that are no longer included currently:

![Simple Trial](images/simpletrialv1.png "Simple Trial")

And these are the results for the Complex trial:

![Complex Trial](images/complextrialv1.png "Complex Trial")

## Blog Post:
The original blog post can be [found here](http://www.raizlabs.com/dev/2015/02/go-dbflow-fastest-android-orm-database-library/)