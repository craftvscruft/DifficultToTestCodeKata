# DifficultToTestCodeKata
A code kata which represents difficult-to-test real-world experiences

## Design notes:
- All classes under unmodifiable are considered out-of-bounds for changes.

  * unmodifiable/objectFilter is intended to represent a database layer
    - query objects and methods which are difficult to mock
    - mix business logic into the database layer

  * unmodifiable/rooms is going to encapsulate state and make it difficult to mock the objects exposed.
    - how can instanceof make mocking difficult?
        * typecast to a different unrelated object?


- Add in a long convoluted method which mixes many concerns and dependencies
  * may be out of the scope of this kata