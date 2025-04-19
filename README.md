```bash
# pull neo4j
docker pull neo4j:latest

# run neo4j
docker run --network my-network --name neo4j --publish=7474:7474 --publish=7687:7687 -e 'NEO4J_AUTH=neo4j/12345678' neo4j:latest

# Optionally, build and tag the image for pushing to a Docker registry
docker build -t phatnt8888/profile-service:1.0.0 .

# Push the tagged image to the Docker registry
docker image push phatnt8888/profile-service:1.0.0

# Pull iamge just push to docke hub
docker pull phatnt8888/profile-service:1.0.0

# Run docker image phatnt8888/profile-service:0.9.0 on docker desktop
docker run --network my-network --name profile-service -p 8082:8082 -e DB_URL=bolt://neo4j:7687 phatnt8888/profile-service:1.0.0

```