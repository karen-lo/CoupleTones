package com.helloworld.kenny.coupletones.tests;

import android.test.ActivityInstrumentationTestCase2;

import com.google.android.gms.maps.model.LatLng;
import com.helloworld.kenny.coupletones.MapsActivity;
import com.helloworld.kenny.coupletones.favorites.FavoritesList;
import com.helloworld.kenny.coupletones.favorites.self.SelfFavoriteEntry;
import com.helloworld.kenny.coupletones.favorites.exceptions.NameInUseException;
import com.helloworld.kenny.coupletones.registration.PartnerInformation;

/**
 * Created by Karen on 5/8/2016.
 */
public class JUnit_test extends ActivityInstrumentationTestCase2<MapsActivity> {

    MapsActivity maps;

    public JUnit_test() {
        super(MapsActivity.class);
    }

    /**
     * Tests add functionality of FavoritesList data structure
     * @throws Exception
     */

    public void test_add() throws Exception
    {
        FavoritesList favoritesList = new FavoritesList();
        boolean check = false;
        favoritesList.addEntry("Library", new LatLng(45, 45));
        try {

            favoritesList.addEntry("Library", new LatLng(45, 45));
        } catch (NameInUseException ex) {
            check = true;
            assertTrue(check);
        }

        if(favoritesList.size() != 1)
        {
            check = false;
        }
        assertTrue(check);
    }

    /**
     * Tests size functionality of FavoritesList data structure
     * @throws Exception
     */
    public void test_size() throws Exception
    {
        FavoritesList favoritesList = new FavoritesList();
        favoritesList.addEntry("Library", new LatLng(45, 45));
        favoritesList.addEntry("Church", new LatLng(25, 65));
        favoritesList.addEntry("Supermarket", new LatLng(83, 29));
        favoritesList.addEntry("Class", new LatLng(32, 24));
        favoritesList.addEntry("Home", new LatLng(335, 554));
        favoritesList.addEntry("Restaurant", new LatLng(934, 753));
        favoritesList.addEntry("Fair", new LatLng(675, 875));
        assertEquals(7, favoritesList.size());
    }


    /**
     * Tests deleteEntry functionality of FavoritesList data structure
     * @throws Exception
     */
    public void test_entry() throws Exception
    {
        FavoritesList favoritesList = new FavoritesList();
        favoritesList.addEntry("Library", new LatLng(45, 45));
        favoritesList.addEntry("Church", new LatLng(25, 65));
        favoritesList.addEntry("Supermarket", new LatLng(83, 29));
        favoritesList.addEntry("Class", new LatLng(32, 24));
        favoritesList.addEntry("Home", new LatLng(335, 554));
        favoritesList.addEntry("Restaurant", new LatLng(934, 753));
        favoritesList.addEntry("Fair", new LatLng(675, 875));
        favoritesList.deleteEntry(0);
        assertEquals("Church", favoritesList.getEntry(0).getName());
    }


    /**
     * Tests existence method of FavoritesList data structure
     * @throws Exception
     */
    public void test_exist() throws Exception
    {
        FavoritesList favoritesList = new FavoritesList();
        SelfFavoriteEntry list = new SelfFavoriteEntry("Taco Bell", new LatLng(68, 68));
        favoritesList.addEntry("Taco Bell", new LatLng(68, 68));
        assertEquals(list.toString(), favoritesList.getEntry(0).toString());
    }

    /**
     * Tests existence method of PartnerInformation data structure
     * @throws Exception
     */
    public void test_partnerInfo() throws Exception {
        PartnerInformation partnerInformation = new PartnerInformation();
        String id = "someID";
        String partnerId = "somePartner";
        String email = "someemail@email.com";

        partnerInformation.registerOwnRegId(id);
        partnerInformation.registerPartner(partnerId, email);

        assertEquals(PartnerInformation.getOwnRegId(), id);
        assertEquals(PartnerInformation.getRegId(), partnerId);
        assertEquals(PartnerInformation.getEmail(), email);
    }



}
