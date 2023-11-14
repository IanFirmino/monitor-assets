package com.ian.monitorassets;

import com.ian.monitorassets.service.IEXCloudService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MonitorAssetsApplicationTests {

	@Autowired
	private IEXCloudService polygonService;

	@Test
	void findStockByTicker() {

	}

}
