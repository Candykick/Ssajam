package hua15.candykick.ssajam;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class SellerMainActivity extends AppCompatActivity implements MapView.MapViewEventListener, MapView.POIItemEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_main);
        String tmp="";

        tmp = readTxt();
        String[] coordinate = tmp.split(",");

        CountDownTimer mCountDown = null;
        Button btUpload = (Button)findViewById(R.id.btUpload);

        final MapView mapView = new MapView(this);

        MapPoint mapPoint1 = MapPoint.mapPointWithGeoCoord(Double.parseDouble(coordinate[0]),Double.parseDouble(coordinate[1]));
        MapPOIItem marker1 = new MapPOIItem();
        marker1.setItemName("자취방1");
        marker1.setTag(1);
        marker1.setMapPoint(mapPoint1);
        marker1.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker1.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker1);

        MapPoint mapPoint2 = MapPoint.mapPointWithGeoCoord(Double.parseDouble(coordinate[2]),Double.parseDouble(coordinate[3]));
        MapPOIItem marker2 = new MapPOIItem();
        marker2.setItemName("자취방2");
        marker2.setTag(2);
        marker2.setMapPoint(mapPoint2);
        marker2.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker2.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker2);

        MapPoint mapPoint3 = MapPoint.mapPointWithGeoCoord(Double.parseDouble(coordinate[4]),Double.parseDouble(coordinate[5]));
        MapPOIItem marker3 = new MapPOIItem();
        marker3.setItemName("자취방3");
        marker3.setTag(3);
        marker3.setMapPoint(mapPoint3);
        marker3.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker3.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker3);

        mapView.setDaumMapApiKey("e5b18b2f8a2ae3f09c848b0f357561a6");
        RelativeLayout container = (RelativeLayout)findViewById(R.id.map_view2);
        container.addView(mapView);

        mCountDown = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);
            }
        }.start();

        btUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SellerMainActivity.this, AdressRoomActivity.class);
                startActivity(i);
            }
        });
    }

    private String readTxt() {
        String data = null;
        InputStream is = getResources().openRawResource(R.raw.roomcoor);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = is.read();
            while(i != -1) {
                byteArrayOutputStream.write(i);
                i = is.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            is.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    @Override
    public void onMapViewInitialized(MapView mapView) {

    }

    @Override
    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewZoomLevelChanged(MapView mapView, int i) {

    }

    @Override
    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {
        //Toast.makeText(this, mapPOIItem.getTag(), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(SellerMainActivity.this, RoomInfoActivity.class);
        i.putExtra("tag",Integer.toString(mapPOIItem.getTag()));
        this.startActivity(i);
    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {

    }

    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {

    }
}
