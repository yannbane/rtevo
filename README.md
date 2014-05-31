Robot Evolution
===============

Robot Evolution is an open source application that uses genetic algorithms to evolve and optimize virtual walking poly-pedal robots. The robots are 2D geometric constructions of rectangles that are connected by virtual motors which apply torque to these rectangles, making them move.

Example:

![Example robot](http://i1.wp.com/yannbane.com/wordpress/wp-content/uploads/2014/03/walker1.png?resize=210%2C199)

I have a blog post explaining most of the application: [jancorazza.com/2014/03/robot-evolution](http://jancorazza.com/2014/03/robot-evolution/).

We use Java and technologies such as JBox2D, Java Concurrent and Swing in order to create an application that will enable users to witness the ongoing evolution process, while much of the work is being done in the backgruond.

The program that we have developed is an interesting example of software inspiried by biological phenomena, and has many useful applications.

The user interface looks like this:

![User interface](http://i0.wp.com/yannbane.com/wordpress/wp-content/uploads/2014/03/ui.png?resize=604%2C313)

It also runs on headless servers (Linux in this case):

![rtevo.jar threads on a Linux server](http://i1.wp.com/yannbane.com/wordpress/wp-content/uploads/2014/03/onServer.png?resize=604%2C394)

## Links

1. [Download](https://drive.google.com/folderview?id=0B_ReuD-ij9sQOFRhc0FOOGRucXc&usp=sharing&tid=0B_ReuD-ij9sQM2hUdEpLd2tRUjg)
2. [Documentation](https://drive.google.com/folderview?id=0B_ReuD-ij9sQSzI1S19YWVB0OVE&usp=sharing&tid=0B_ReuD-ij9sQM2hUdEpLd2tRUjg)
3. [Post about Robot Evolution](http://jancorazza.com/2014/03/robot-evolution/)

## Usage

Run the program like this:

`java -jar rtevo.jar configuration.properties`

You can edit the configuration file to suit your needs.

## Croatian

Robot Evolution je program koji koristi genetske algoritme kako bi optimizirao dizajn hodajućih robota. Koristimo Javu i tehnologije poput JBox2Da, Java Concurrent i Swinga kako bi napravili aplikaciju koja će korisnicima omogućiti da toj evoluciji svjedoče uživo, dok se većina posla obavlja u pozadini.

Program koji smo razvili zanimljiv je primjer softvera koji je inspiriran prirodnim fenomenima te ima mnogo korisnih primjena. 
