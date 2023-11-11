TOKEN=$(http -f POST :8080/oauth2/token grant_type=client_credentials scope='user.read' -a admin-client:secret | jq -r ".access_token")

http -f POST :8080/oauth2/introspect token=$TOKEN -a admin-client:secret

http :8081/hello "authorization: bearer $TOKEN"
curl -H"authorization: bearer $TOKEN" http://localhost:8081/hello 