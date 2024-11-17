import http from "../http-common"; 

class AgencyService {
  getAllAgencys(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/agency/agencys`, searchDTO);
  }

  get(agencyId) {
    return this.getRequest(`/agency/${agencyId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/agency?field=${matchData}`, null);
  }

  addAgency(data) {
    return http.post("/agency/addAgency", data);
  }

  update(data) {
  	return http.post("/agency/updateAgency", data);
  }
  
  uploadImage(data,agencyId) {
  	return http.postForm("/agency/uploadImage/"+agencyId, data);
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

export default new AgencyService();
