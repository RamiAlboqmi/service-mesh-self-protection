# Service-mesh-self-protection
This repository helps us to share our source code with the research community for the research paper "Toward Enabling Self-Protection Ability to Service Mesh Layer in Microservice Architecture".

In order to apply our approach with the same experiment we did, please watch this YouTube video (URL) which we will do the following steps: 
1. Install kubernetes and docker (you might follow Docker.com guideline on the URL: https://docs.docker.com/desktop/ )
2. Install Istio service mesh (you might follow Isito.io guideline on the URL: https://istio.io/latest/docs/setup/getting-started/)
3. Install the Demo app "Bookinfo" form Istio.io main page on this URL: https://istio.io/latest/docs/examples/bookinfo/
4. Build your Adaptation Assessment Framework (AAF) image to either your local Docker repository (the code in AAF directory) or you can use our public docker image by searching by tag name: rami966/aaf or use this URL: https://hub.docker.com/r/rami966/aaf
5. Install our YAML files in the direcotry Install by applying the command: kubectl apply -f . 

