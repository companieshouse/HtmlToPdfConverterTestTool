# HtmlToPdfConverterTestTool
A tool that allows testing of the conversion so that we can test in isolation and avoid using paper prints.

Html 2 Pdf Converter Feature Testbed environment
-------------------------------------------------------

This is a simple java application created as a simple testbed to directly convert well formed
HTML5 file into pdf version.

To use, please follow the easy step by step points below.

Step 1. Unzip the zip file (html2pdf-testbed.zip) and it will create a folder - html2pdf-testbed

Step 2. cd html2pdf-testbed

Step 3. java -jar Converter.jar

Step 4. enter the input html file to convert and the output file name

Step 5. Enter sample/templates/sample-letter-template-v1.htm sample/output/sample-letter-template-v1.pdf

Step 6. Open the pdf file created :  sample/output/sample-letter-template-v1.pdf


File structure

  - css : this contains the css style sheet files

  - images : this contains the image files that to use in the html files / templates

  - templates : This is the actual html templates that needs to be converted to pdf

  - output - This is the folder for the generated pdf files

Troubleshooting

1. Java exception error e.g:

This is pointing to error with the html template file. The html should be a well formed html5 file and tags must be closed.

for example : <link rel="stylesheet" href="styles.css"></style>