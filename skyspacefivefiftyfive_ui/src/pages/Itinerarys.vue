<template>
  <div class="content">
    <div class="row">
      <div class="col-12">
        <card class="card-plain">
          <!-- <template slot="header">
            <h4 class="card-title">Table on Plain Background</h4>
            <p class="category">Here is a subtitle for this table</p>
          </template>-->
          <div class="table-full-width text-left">
            <itinerary-table
            v-if="itinerarys && itinerarys.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:itinerarys="itinerarys"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-itinerarys="getAllItinerarys"
             >

            </itinerary-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import ItineraryTable from "@/components/ItineraryTable";
import ItineraryService from "../services/ItineraryService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    ItineraryTable,
  },
  data() {
    return {
      itinerarys: [],
	  totalElements: 0,
      page: 0,
      searchQuery: '',     
      table1: {
        title: "Simple Table",
        columns: [...tableColumns],
        data: [...tableData],
      },
    };
  },
  methods: {
    async getAllItinerarys(sortBy='itineraryId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await ItineraryService.getAllItinerarys(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.itinerarys.length) {
					this.itinerarys = response.data.itinerarys;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching itinerarys:", error);
        }
        
      } catch (error) {
        console.error("Error fetching itinerary details:", error);
      }
    },
  },
  mounted() {
    this.getAllItinerarys();
  },
  created() {
    this.$root.$on('searchQueryForItinerarysChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllItinerarys();
    })
  }
};
</script>
<style></style>
