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
            <policy-table
            v-if="policys && policys.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:policys="policys"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-policys="getAllPolicys"
             >

            </policy-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import PolicyTable from "@/components/PolicyTable";
import PolicyService from "../services/PolicyService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    PolicyTable,
  },
  data() {
    return {
      policys: [],
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
    async getAllPolicys(sortBy='policyId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await PolicyService.getAllPolicys(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.policys.length) {
					this.policys = response.data.policys;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching policys:", error);
        }
        
      } catch (error) {
        console.error("Error fetching policy details:", error);
      }
    },
  },
  mounted() {
    this.getAllPolicys();
  },
  created() {
    this.$root.$on('searchQueryForPolicysChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllPolicys();
    })
  }
};
</script>
<style></style>
