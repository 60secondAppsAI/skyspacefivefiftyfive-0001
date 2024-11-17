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
            <agency-table
            v-if="agencys && agencys.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:agencys="agencys"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-agencys="getAllAgencys"
             >

            </agency-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import AgencyTable from "@/components/AgencyTable";
import AgencyService from "../services/AgencyService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    AgencyTable,
  },
  data() {
    return {
      agencys: [],
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
    async getAllAgencys(sortBy='agencyId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await AgencyService.getAllAgencys(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.agencys.length) {
					this.agencys = response.data.agencys;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching agencys:", error);
        }
        
      } catch (error) {
        console.error("Error fetching agency details:", error);
      }
    },
  },
  mounted() {
    this.getAllAgencys();
  },
  created() {
    this.$root.$on('searchQueryForAgencysChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllAgencys();
    })
  }
};
</script>
<style></style>
