# SpeedTesting
Speed testing many processes, loops and structures.

There have been a number of times where me, or someone on my team have asked, "would it be faster to do it this way instead?"
This is a compliation of some of the tests that we built to try and help answer the question.

BigDecimalTest      - speed testing big decimal assignment and retrevial

BooleanSpeedTest    - testing the different ways to test a boolean variable.

HashTests           - testing some different hash structures.

IFvsSwitch          - speed testing if else versus a switch or cases statement

TestPaddingSpeed    - speed testing differnt was to left and right pad of a string.

TestStringEqual     - speed testing strimg compares

StringBuildervsStringAdd  - test the speed performance of the String builder append vs String + String
  It turns out that StringBuilder is much more efficient than String + String. We tested only a few different scenarios, all of which proved that SB append was faster than String +.

... and others, more to come
