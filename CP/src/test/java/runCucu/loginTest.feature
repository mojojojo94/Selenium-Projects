Feature: Log in to iBusiness
   In order to verify that login button works correctly
   As a user of iBusiness
   I should be able to login and see the the "Welcome to iBusiness" page

   Scenario: Catalog
   Given I open Catalog
   When I click log yourself in and enter username as "ecalix@test.com" and enter password as "test123"
   Then I should get result as "Welcome to iBusiness"