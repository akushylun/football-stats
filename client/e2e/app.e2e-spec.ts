import { FootballStatsClientPage } from './app.po';

describe('football-stats-client App', () => {
  let page: FootballStatsClientPage;

  beforeEach(() => {
    page = new FootballStatsClientPage();
  });

  it('should display welcome message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg).toEqual('Welcome to app!!'))
      .then(done, done.fail);
  });
});
