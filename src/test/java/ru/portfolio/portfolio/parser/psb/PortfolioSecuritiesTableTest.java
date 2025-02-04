/*
 * InvestBook
 * Copyright (C) 2020  Vitalii Ananev <spacious-team@ya.ru>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package ru.investbook.parser.psb;

import org.mockito.Mock;
import org.spacious_team.broker.pojo.Security;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import ru.investbook.parser.SecurityRegistrar;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

@Ignore
public class PortfolioSecuritiesTableTest {

    @Mock
    SecurityRegistrar securityRegistrar;

    @DataProvider(name = "isin")
    Object[][] getData() {
        return new Object[][] {{"E:\\1.xlsx", "RU000A0ZZDQ8", "RU000A0JV7J9" }};
    }

    @Test(dataProvider = "isin")
    void testIsin(String report, String firstIsin, String lastIsin) throws IOException {
        List<Security> data = new SecuritiesTable(new PsbBrokerReport(report, securityRegistrar)).getData();
        assertEquals(data.get(0).getId(), firstIsin);
        assertEquals(data.get(data.size() - 1).getId(), lastIsin);
    }
}