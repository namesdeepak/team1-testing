# team1-testing
CS673-Summer Project Test automation code for Team1 project TracKing

Pre-reqs
1. Install maven
2. Download chromedriver from http://chromedriver.chromium.org/downloads to your local directory
3. TracKing application is up and running

Run tests
1. Clone the repository
2. From the home directory of the repo run
mvn test -DargLine="-Dwebdriver.chrome.driver=<path_to_chrome_driver.exe> -Dwebdriver.baseurl=base_url"

ex : 
mvn test -DargLine="-Dwebdriver.chrome.driver=C:\sel-chrome-driver\chromedriver.exe -Dwebdriver.baseurl=http://localhost:3000"

Once the tests complete, the reports will be available at test-output\index.html

