# ExoplanetDemo
rest api to downloads a catalog of exoplanet data and displays planet information

Application Run instructions
1. clone the code locally
2. build the code using maven
3. set/update port in application.properties
   server.port=8080
4. use get request to get following information
  a. the number of orphan planets(no star)
     http://localhost:{port}/orphanplanet
  b. the name of planet orbiting hottest star
     http://localhost:{port}/hottestplanet
  c. size of planets grouped by discovery year
     http://localhost:{port}/planetssizebyyear   
