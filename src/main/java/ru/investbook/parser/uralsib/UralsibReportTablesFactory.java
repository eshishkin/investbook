/*
 * InvestBook
 * Copyright (C) 2020  Vitalii Ananev <an-vitek@ya.ru>
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

package ru.investbook.parser.uralsib;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.investbook.parser.BrokerReport;
import ru.investbook.parser.ReportTables;
import ru.investbook.parser.ReportTablesFactory;
import ru.investbook.view.ForeignExchangeRateService;

@Component
@RequiredArgsConstructor
public class UralsibReportTablesFactory implements ReportTablesFactory {

    private final ForeignExchangeRateService foreignExchangeRateService;

    @Override
    public boolean canCreate(BrokerReport brokerReport) {
        return (brokerReport instanceof UralsibBrokerReport);
    }

    @Override
    public ReportTables create(BrokerReport brokerReport) {
        return new UralsibReportTables((UralsibBrokerReport) brokerReport, foreignExchangeRateService);
    }
}
