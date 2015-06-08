/*
 * Copyright (C) 2015 NS Solutions Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.htmlhifive.testlib.core.selenium;

import java.awt.image.BufferedImage;
import java.net.URL;

import com.htmlhifive.testlib.image.util.ImageUtils;

/**
 * Internet Explorer 8で利用する{@link org.openqa.selenium.WebDriver}
 */
class MrtInternetExplorer8Driver extends MrtInternetExplorerDriver {

	/**
	 * コンストラクタ
	 * 
	 * @param remoteAddress RemoteWebDriverServerのアドレス
	 * @param capabilities Capability
	 */
	MrtInternetExplorer8Driver(URL remoteAddress, MrtCapabilities capabilities) {
		super(remoteAddress, capabilities);
	}

	@Override
	protected MrtWebElement newMrtWebElement() {
		return new MrtInternetExplorer8WebElement();
	}

	@Override
	public BufferedImage getEntirePageScreenshot() {
		// IE7,8は上下左右2pxを削る
		BufferedImage screenshot = super.getEntirePageScreenshot();
		return ImageUtils.trim(screenshot, 2, 2, 2, 2);
	}

}