import http from "../http-common"; 

class PolicyService {
  getAllPolicys(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/policy/policys`, searchDTO);
  }

  get(policyId) {
    return this.getRequest(`/policy/${policyId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/policy?field=${matchData}`, null);
  }

  addPolicy(data) {
    return http.post("/policy/addPolicy", data);
  }

  update(data) {
  	return http.post("/policy/updatePolicy", data);
  }
  
  uploadImage(data,policyId) {
  	return http.postForm("/policy/uploadImage/"+policyId, data);
  }




	postRequest(url, data) {
		return http.post(url, data);
      };

	getRequest(url, params) {
        return http.get(url, {
        	params: params
        });
    };

}

export default new PolicyService();
