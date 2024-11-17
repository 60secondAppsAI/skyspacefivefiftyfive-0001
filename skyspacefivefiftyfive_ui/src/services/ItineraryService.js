import http from "../http-common"; 

class ItineraryService {
  getAllItinerarys(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/itinerary/itinerarys`, searchDTO);
  }

  get(itineraryId) {
    return this.getRequest(`/itinerary/${itineraryId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/itinerary?field=${matchData}`, null);
  }

  addItinerary(data) {
    return http.post("/itinerary/addItinerary", data);
  }

  update(data) {
  	return http.post("/itinerary/updateItinerary", data);
  }
  
  uploadImage(data,itineraryId) {
  	return http.postForm("/itinerary/uploadImage/"+itineraryId, data);
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

export default new ItineraryService();
