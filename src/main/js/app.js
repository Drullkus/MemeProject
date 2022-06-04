const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {memers: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/memers/all'}).done(response => {
            this.setState({memers: response.entity._embedded.memers});
        });
    }

    render() {
        return (
            <MemerList memers={this.state.memers}/>
        )
    }
}

class MemerList extends React.Component{
    render() {
        const memers = this.props.memers.map(memer =>
            <Memer key={memer._links.self.href} memer={memer}/>
        );
        return (
            <table>
                <tbody>
                <tr>
                    <th>ID</th>
                    <th>Display Name</th>
                </tr>
                {memers}
                </tbody>
            </table>
        )
    }
}

class Memer extends React.Component{
    render() {
        return (
            <tr>
                <td>{this.props.memer.id}</td>
                <td>{this.props.memer.displayName}</td>
            </tr>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
)
