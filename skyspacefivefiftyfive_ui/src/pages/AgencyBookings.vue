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
            <agencyBooking-table
            v-if="agencyBookings && agencyBookings.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:agencyBookings="agencyBookings"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-agency-bookings="getAllAgencyBookings"
             >

            </agencyBooking-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import AgencyBookingTable from "@/components/AgencyBookingTable";
import AgencyBookingService from "../services/AgencyBookingService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    AgencyBookingTable,
  },
  data() {
    return {
      agencyBookings: [],
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
    async getAllAgencyBookings(sortBy='agencyBookingId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await AgencyBookingService.getAllAgencyBookings(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.agencyBookings.length) {
					this.agencyBookings = response.data.agencyBookings;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching agencyBookings:", error);
        }
        
      } catch (error) {
        console.error("Error fetching agencyBooking details:", error);
      }
    },
  },
  mounted() {
    this.getAllAgencyBookings();
  },
  created() {
    this.$root.$on('searchQueryForAgencyBookingsChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllAgencyBookings();
    })
  }
};
</script>
<style></style>
