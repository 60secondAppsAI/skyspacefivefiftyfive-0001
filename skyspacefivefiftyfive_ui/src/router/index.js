import Vue from "vue";
import VueRouter from "vue-router";
import DefaultLayout from "@/layouts/DefaultLayout.vue";
import Flights from  '@/pages/Flights.vue';
import FlightDetail from  '@/pages/FlightDetail.vue';
import Passengers from  '@/pages/Passengers.vue';
import PassengerDetail from  '@/pages/PassengerDetail.vue';
import Bookings from  '@/pages/Bookings.vue';
import BookingDetail from  '@/pages/BookingDetail.vue';
import Payments from  '@/pages/Payments.vue';
import PaymentDetail from  '@/pages/PaymentDetail.vue';
import Aircrafts from  '@/pages/Aircrafts.vue';
import AircraftDetail from  '@/pages/AircraftDetail.vue';
import Airlines from  '@/pages/Airlines.vue';
import AirlineDetail from  '@/pages/AirlineDetail.vue';
import Crews from  '@/pages/Crews.vue';
import CrewDetail from  '@/pages/CrewDetail.vue';
import CrewAssignments from  '@/pages/CrewAssignments.vue';
import CrewAssignmentDetail from  '@/pages/CrewAssignmentDetail.vue';
import Itinerarys from  '@/pages/Itinerarys.vue';
import ItineraryDetail from  '@/pages/ItineraryDetail.vue';
import Luggages from  '@/pages/Luggages.vue';
import LuggageDetail from  '@/pages/LuggageDetail.vue';
import Routes from  '@/pages/Routes.vue';
import RouteDetail from  '@/pages/RouteDetail.vue';
import Tickets from  '@/pages/Tickets.vue';
import TicketDetail from  '@/pages/TicketDetail.vue';
import Terminals from  '@/pages/Terminals.vue';
import TerminalDetail from  '@/pages/TerminalDetail.vue';
import Agencys from  '@/pages/Agencys.vue';
import AgencyDetail from  '@/pages/AgencyDetail.vue';
import AgencyBookings from  '@/pages/AgencyBookings.vue';
import AgencyBookingDetail from  '@/pages/AgencyBookingDetail.vue';
import Policys from  '@/pages/Policys.vue';
import PolicyDetail from  '@/pages/PolicyDetail.vue';
import Offers from  '@/pages/Offers.vue';
import OfferDetail from  '@/pages/OfferDetail.vue';
import BaggageClaims from  '@/pages/BaggageClaims.vue';
import BaggageClaimDetail from  '@/pages/BaggageClaimDetail.vue';
import LoyaltyPrograms from  '@/pages/LoyaltyPrograms.vue';
import LoyaltyProgramDetail from  '@/pages/LoyaltyProgramDetail.vue';
import Meals from  '@/pages/Meals.vue';
import MealDetail from  '@/pages/MealDetail.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: () => import("../views/HomeView.vue"),
			redirect: '/flights',
																				  },
  {
    path: "/pricing",
    name: "PricingView",
    component: () => import("../views/PricingView.vue"),
  },
  {
    path: "/arts-gallery",
    name: "ArtsGalleryView",
    component: () => import("../views/ArtsGalleryView.vue"),
  },
  {
    path: "/checkout/:id",
    name: "CheckoutView",
    component: () => import("../views/CheckoutView.vue"),
  },
  {
    path: "/stripe-checkout",
    name: "StripeCheckoutView",
    component: () => import("../views/StripeCheckoutView.vue"),
  },
	{
		path: '/flights',
		name: 'Flights',
		layout: DefaultLayout,
		component: Flights,
	},
	{
	    path: '/flight/:flightId', 
	    name: 'FlightDetail',
		layout: DefaultLayout,
	    component: FlightDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/passengers',
		name: 'Passengers',
		layout: DefaultLayout,
		component: Passengers,
	},
	{
	    path: '/passenger/:passengerId', 
	    name: 'PassengerDetail',
		layout: DefaultLayout,
	    component: PassengerDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/bookings',
		name: 'Bookings',
		layout: DefaultLayout,
		component: Bookings,
	},
	{
	    path: '/booking/:bookingId', 
	    name: 'BookingDetail',
		layout: DefaultLayout,
	    component: BookingDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/payments',
		name: 'Payments',
		layout: DefaultLayout,
		component: Payments,
	},
	{
	    path: '/payment/:paymentId', 
	    name: 'PaymentDetail',
		layout: DefaultLayout,
	    component: PaymentDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/aircrafts',
		name: 'Aircrafts',
		layout: DefaultLayout,
		component: Aircrafts,
	},
	{
	    path: '/aircraft/:aircraftId', 
	    name: 'AircraftDetail',
		layout: DefaultLayout,
	    component: AircraftDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/airlines',
		name: 'Airlines',
		layout: DefaultLayout,
		component: Airlines,
	},
	{
	    path: '/airline/:airlineId', 
	    name: 'AirlineDetail',
		layout: DefaultLayout,
	    component: AirlineDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/crews',
		name: 'Crews',
		layout: DefaultLayout,
		component: Crews,
	},
	{
	    path: '/crew/:crewId', 
	    name: 'CrewDetail',
		layout: DefaultLayout,
	    component: CrewDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/crewAssignments',
		name: 'CrewAssignments',
		layout: DefaultLayout,
		component: CrewAssignments,
	},
	{
	    path: '/crewAssignment/:crewAssignmentId', 
	    name: 'CrewAssignmentDetail',
		layout: DefaultLayout,
	    component: CrewAssignmentDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/itinerarys',
		name: 'Itinerarys',
		layout: DefaultLayout,
		component: Itinerarys,
	},
	{
	    path: '/itinerary/:itineraryId', 
	    name: 'ItineraryDetail',
		layout: DefaultLayout,
	    component: ItineraryDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/luggages',
		name: 'Luggages',
		layout: DefaultLayout,
		component: Luggages,
	},
	{
	    path: '/luggage/:luggageId', 
	    name: 'LuggageDetail',
		layout: DefaultLayout,
	    component: LuggageDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/routes',
		name: 'Routes',
		layout: DefaultLayout,
		component: Routes,
	},
	{
	    path: '/route/:routeId', 
	    name: 'RouteDetail',
		layout: DefaultLayout,
	    component: RouteDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/tickets',
		name: 'Tickets',
		layout: DefaultLayout,
		component: Tickets,
	},
	{
	    path: '/ticket/:ticketId', 
	    name: 'TicketDetail',
		layout: DefaultLayout,
	    component: TicketDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/terminals',
		name: 'Terminals',
		layout: DefaultLayout,
		component: Terminals,
	},
	{
	    path: '/terminal/:terminalId', 
	    name: 'TerminalDetail',
		layout: DefaultLayout,
	    component: TerminalDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/agencys',
		name: 'Agencys',
		layout: DefaultLayout,
		component: Agencys,
	},
	{
	    path: '/agency/:agencyId', 
	    name: 'AgencyDetail',
		layout: DefaultLayout,
	    component: AgencyDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/agencyBookings',
		name: 'AgencyBookings',
		layout: DefaultLayout,
		component: AgencyBookings,
	},
	{
	    path: '/agencyBooking/:agencyBookingId', 
	    name: 'AgencyBookingDetail',
		layout: DefaultLayout,
	    component: AgencyBookingDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/policys',
		name: 'Policys',
		layout: DefaultLayout,
		component: Policys,
	},
	{
	    path: '/policy/:policyId', 
	    name: 'PolicyDetail',
		layout: DefaultLayout,
	    component: PolicyDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/offers',
		name: 'Offers',
		layout: DefaultLayout,
		component: Offers,
	},
	{
	    path: '/offer/:offerId', 
	    name: 'OfferDetail',
		layout: DefaultLayout,
	    component: OfferDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/baggageClaims',
		name: 'BaggageClaims',
		layout: DefaultLayout,
		component: BaggageClaims,
	},
	{
	    path: '/baggageClaim/:baggageClaimId', 
	    name: 'BaggageClaimDetail',
		layout: DefaultLayout,
	    component: BaggageClaimDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/loyaltyPrograms',
		name: 'LoyaltyPrograms',
		layout: DefaultLayout,
		component: LoyaltyPrograms,
	},
	{
	    path: '/loyaltyProgram/:loyaltyProgramId', 
	    name: 'LoyaltyProgramDetail',
		layout: DefaultLayout,
	    component: LoyaltyProgramDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/meals',
		name: 'Meals',
		layout: DefaultLayout,
		component: Meals,
	},
	{
	    path: '/meal/:mealId', 
	    name: 'MealDetail',
		layout: DefaultLayout,
	    component: MealDetail,
	    props: true // Pass route params as props to the component
  	},
];

const router = new VueRouter({
  mode: "hash",
  base: process.env.BASE_URL,
  routes,
});

export default router;
