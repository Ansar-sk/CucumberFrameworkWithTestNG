@all
Feature: Validate login functionality with background

Background: To start browser and lauch the app
Given User should start "chrome"
And user should open the app using url "https://adactinhotelapp.com/SearchHotel.php"


Scenario:
To validate login using multiple login creds

When user enters username "reyaz0806" by using xpath "//input[@name='username']"
And user enters password "reyaz123" by using xapth "//input[@name='password']"
Then user clicks on submit button using xapth "//input[@name='login']"
And user verifies the title "Adactin.com - Search Hotel"

Scenario:
To validate login using incorrect username login creds

When user enters username "reyaz1111" by using xpath "//input[@name='username']"
And user enters password "reyaz123" by using xapth "//input[@name='password']"
Then user clicks on submit button using xapth "//input[@name='login']"
And user verifies the title "Adactin.com - Hotel Reservation System"

Scenario:
To validate login using w=incorrect password login creds

When user enters username "reyaz0806" by using xpath "//input[@name='username']"
And user enters password "reyaz0000" by using xapth "//input[@name='password']"
Then user clicks on submit button using xapth "//input[@name='login']"
And user verifies the title "Adactin.com - Hotel Reservation System"

Scenario:
To validate login using wrong id and password login creds

When user enters username "reyaz0808" by using xpath "//input[@name='username']"
And user enters password "reyaz111" by using xapth "//input[@name='password']"
Then user clicks on submit button using xapth "//input[@name='login']"
And user verifies the title "Adactin.com - Hotel Reservation System"
