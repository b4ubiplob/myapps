# myapps

## sampleweb
This is a simple web application with jax rs. It provides two api endpoints
1. http://<server>/sampleweb/api/hello
2. http://<server>/sampleweb/api/hello/json
  
##sampledbwebapp
This is a sample webapp with mysql as database. It runs in tomcat version 8.5
###Prerequisites
1. Create a schema "sample_db" in mysql.
2. Update connection parameters in src/main/resources/META-INF/persistence.xml

###services

GET
1. http://<server>/sampleweb/api/hello
2. http://<server>/sampleweb/api/hello/json
3. http://<server>/sampleweb/api/users
  
POST
1. http://<server>/sampleweb/api/users

headers
Content-Type : application/json
payload
{
	"username" : "user34",
	"password" : "pass23"
}


