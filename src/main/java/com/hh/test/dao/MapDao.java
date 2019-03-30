package com.hh.test.dao;

import java.util.List;

import com.hh.test.pojo.DeviceLbs;

public interface MapDao {

	List<DeviceLbs> getDeviceLbsByDeviceId(String deviceId);
}
