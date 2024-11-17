import http from "../http-common"; 

class AgencyBookingService {
  getAllAgencyBookings(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/agencyBooking/agencyBookings`, searchDTO);
  }

  get(agencyBookingId) {
    return this.getRequest(`/agencyBooking/${agencyBookingId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/agencyBooking?field=${matchData}`, null);
  }

  addAgencyBooking(data) {
    return http.post("/agencyBooking/addAgencyBooking", data);
  }

  update(data) {
  	return http.post("/agencyBooking/updateAgencyBooking", data);
  }
  
  uploadImage(data,agencyBookingId) {
  	return http.postForm("/agencyBooking/uploadImage/"+agencyBookingId, data);
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

export default new AgencyBookingService();
