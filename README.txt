Installation Instructions (similar to the installation instructions given by Constantinos Constantinides in his "Getting started with adbc in Java/AspectJ under Eclipse" document:

- Download the latest Eclipse version from the following link: https://www.eclipse.org/downloads/
	Note: Our Eclipse version is 2018-12 (4.10.0)

- Download the latest adbc jar from this link: http://timmolderez.be/builds/adbc/
	Note: The zip we used is adbc-0.3.1.zip.
	
- Extract the adbc jar file from the zip archive and keep it somewhere handy.
	
- After installing Eclipse, go to "Help" > "Install New Software" and paste the Site URL for the latest AJDT version which is compatible with your Eclipse version. See https://www.eclipse.org/ajdt/downloads/ for a list of AJDT versions.
	Note: The site URL we used was http://download.eclipse.org/tools/ajdt/410/dev/update which is the Development build for Eclipse 4.10

- Go through the process of installing the plugin. Eclipse might ask to restart in order for the changes to take effect.

- If the project isn't already an AspectJ project, convert it by right-clicking on the project and going to "Configure" > "Convert to AspectJ Project".

- Right-click on the project and go to "Properties" > "AspectJ Build" > "Inpath" > "Add External JARs", and add the adbc jar extracted earlier by naviguating to it.